public class Company {
    private Worker[] workers = new Worker[100];
    private int count = 0;

    public Company(String kil, Worker[] workers) {
        this.workers = workers;
    }

    public void addWorker(String type, String name, int salary, String department) {
        if (this.count < this.workers.length) {
            this.workers[this.count++] = new Worker(department, salary, name, type);
        } else {
            System.out.println("Company is full!");
        }
    }
    public void removeWorker (String name){
        for (int i = 0; i < this.count; ++i) {
            if (this.workers[i].getName().equalsIgnoreCase(name)) {
                this.workers[i] = this.workers[--this.count];
                this.workers[this.count] = null;
                break;
            }
        }
    }

    public Double totalSalary() {
        Double total = 0.0;
        for (int i = 0; i < this.count; ++i) {
            if (this.workers[i] != null) {
                total += this.workers[i].getSalary();
            }
        }
        return total;
    }

    public Double srSalary() {
        Double total = 0.0;
        for (int i = 0; i < this.count; ++i) {
            if (this.workers[i] != null) {
                total += this.workers[i].getSalary();
            }
        }
        return total/this.count;
    }
}
