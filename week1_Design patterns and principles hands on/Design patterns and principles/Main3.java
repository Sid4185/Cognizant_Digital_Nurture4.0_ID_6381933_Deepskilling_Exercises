class Computer {
    private String cpu, ram, storage;
    private Computer(Builder b) {
        this.cpu = b.cpu;
        this.ram = b.ram;
        this.storage = b.storage;
    }
    public String toString() {
        return "CPU: " + cpu + ", RAM: " + ram + ", Storage: " + storage;
    }
    static class Builder {
        private String cpu, ram, storage;
        public Builder setCpu(String cpu) { this.cpu = cpu; return this; }
        public Builder setRam(String ram) { this.ram = ram; return this; }
        public Builder setStorage(String storage) { this.storage = storage; return this; }
        public Computer build() { return new Computer(this); }
    }
}

public class Main3 {
    public static void main(String[] args) {
        Computer pc = new Computer.Builder().setCpu("i7").setRam("16GB").setStorage("1TB").build();
        System.out.println(pc);
    }
}
