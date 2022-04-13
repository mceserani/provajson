package it.edu.polomanettiporciatti.provajson;

public class Configuration {

    // Hostname or IP address of the server
    private String hostname;
    private int port;

    public Configuration(){
    }

    public Configuration(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public String getHostname() {
        return hostname;
    }

    public int getPort() {
        return port;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public void setPort(int port) {
        if (port > 0 && port < 65535) {
            this.port = port;
        }
        else
            throw new IllegalArgumentException("Port must be between 0 and 65535");
    }

    @Override
    public String toString() {
        return "Configuration{" + "hostname=" + hostname + ", port=" + port + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.hostname != null ? this.hostname.hashCode() : 0);
        hash = 97 * hash + this.port;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Configuration other = (Configuration) obj;
        if ((this.hostname == null) ? (other.hostname != null) : !this.hostname.equals(other.hostname)) {
            return false;
        }
        if (this.port != other.port) {
            return false;
        }
        return true;
    }
    
}
