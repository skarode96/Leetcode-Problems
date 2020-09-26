package draftkings;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        ConsoleProcessor processor = new ConsoleProcessor();
        processor.processAllLines();
    }
}

class ConsoleProcessor {

    public OrgChart orgChart = new OrgChart();

    public void processAllLines() {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        Integer numLines = 0;

        try {
            numLines = Integer.valueOf(line.trim());
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < numLines; i++) {
            processLine(in.nextLine());
        }

        in.close();
    }

    protected void processLine(String line) {
        String[] parsedCommand = line.split(",");

        // ignore empty lines
        if (parsedCommand.length == 0) {
            return;
        }

        switch (parsedCommand[0]) {
            case "add":
                orgChart.add(parsedCommand[1], parsedCommand[2], parsedCommand[3]);
                break;
            case "print":
                orgChart.print();
                break;
            case "remove":
                orgChart.remove(parsedCommand[1]);
                break;
            case "move":
                orgChart.move(parsedCommand[1], parsedCommand[2]);
                break;
            case "count":
                System.out.println(orgChart.count(parsedCommand[1]));
                break;
        }
    }
}

class Employee {
    private String id;
    private String name;
    private Employee manager;
    private List<Employee> reportingEmployees;

    Employee(String id, String name) {
        this.id = id;
        this.name = name;
        reportingEmployees = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public List<Employee> getReportingEmployees() {
        return reportingEmployees;
    }

    public void setReportingEmployees(List<Employee> reportingEmployees) {
        this.reportingEmployees = reportingEmployees;
    }

    public void print(String prefix){
        System.out.println(prefix + this.manager.name + " [" + this.manager.id + "]");
    }
}
class OrgChart {
    Employee head = new Employee("-1", "root");
    Map<String, Employee> allEmployees = new HashMap<>();
    OrgChart(){
        allEmployees.put("-1", head);
    }
    public void add(String id, String name, String managerId)
    {
        if (!allEmployees.containsKey(id)) {
            Employee newEmployee = new Employee(id, name);
            allEmployees.put(id, newEmployee);
            Employee newManager = allEmployees.getOrDefault(managerId, head);
            newEmployee.setManager(newManager);
            newManager.getReportingEmployees().add(newEmployee);
        }
        //throw new UnsupportedOperationException();
    }

    public void print()
    {
        head.getReportingEmployees().stream().forEach(baseEmployee -> {
            printMember(baseEmployee, "");
        });
    }
    private void printMember (Employee head, String prefix) {
        head.print(prefix);
        head.getReportingEmployees().stream().forEach(reportee -> {
            printMember(reportee, prefix + "  ");
        });
    }

    public void remove(String employeeId)
    {
        if (allEmployees.containsKey(employeeId)) {
            Employee tobeRemoved = allEmployees.get(employeeId);

            tobeRemoved.getReportingEmployees()
                    .stream()
                    .forEach(reportee -> {
                        Employee manager = reportee.getManager();
                        manager.setManager(tobeRemoved.getManager());
                        manager.getReportingEmployees().add(reportee);
                    });
            Employee manager = tobeRemoved.getManager();
            manager.getReportingEmployees().remove(tobeRemoved);
            allEmployees.remove(employeeId);
        }
        //throw new UnsupportedOperationException();
    }

    public void move(String employeeId, String newManagerId)
    {
        if (allEmployees.containsKey(employeeId) && allEmployees.containsKey(newManagerId)) {
            Employee toBeMoved = allEmployees.get(employeeId);
            Employee newManager = allEmployees.get(newManagerId);

            newManager.getReportingEmployees().add(toBeMoved);
            toBeMoved.getManager().getReportingEmployees().remove(toBeMoved);
            toBeMoved.setManager(newManager);
        }
        //throw new UnsupportedOperationException();
    }

    public int count(String employeeId)
    {
        if (allEmployees.containsKey(employeeId)) {
            return countMembers(allEmployees.get(employeeId)) - 1;
        }
        return -1;
        //throw new UnsupportedOperationException();
    }
    private int countMembers (Employee head) {
        int count = 1;

        for (Employee reportee: head.getReportingEmployees()) {
            count += countMembers(reportee);
        }

        return count;

    }
}