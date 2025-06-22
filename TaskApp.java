class Task {
    String taskId, taskName, status;
    Task next;

    Task(String id, String name, String stat) {
        this.taskId = id;
        this.taskName = name;
        this.status = stat;
    }
}

class TaskList {
    private Task head;

    public void add(Task t) {
        t.next = head;
        head = t;
    }

    public Task search(String id) {
        Task curr = head;
        while (curr != null) {
            if (curr.taskId.equals(id)) return curr;
            curr = curr.next;
        }
        return null;
    }

    public void delete(String id) {
        Task curr = head, prev = null;
        while (curr != null && !curr.taskId.equals(id)) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) return;
        if (prev == null) head = curr.next;
        else prev.next = curr.next;
    }

    public void show() {
        Task curr = head;
        while (curr != null) {
            System.out.println(curr.taskName + " - " + curr.status);
            curr = curr.next;
        }
    }
}

public class TaskApp {
    public static void main(String[] args) {
        TaskList list = new TaskList();
        list.add(new Task("T1", "Code", "Pending"));
        list.add(new Task("T2", "Test", "Done"));
        list.show();
    }
}

