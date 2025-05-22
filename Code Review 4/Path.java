/* Продолжение задания №3.3 */
public class Path {
    private City destination;
    private int cost;

    public Path(City destination, int cost) {
        if (destination == null) {
            System.out.println("Ошибка: город назначения не может быть null");
            throw new IllegalArgumentException("Destination city cannot be null");
        }
        if (cost <= 0) {
            System.out.println("Ошибка: стоимость пути должна быть положительной");
            throw new IllegalArgumentException("Path cost must be positive");
        }
        this.destination = destination;
        this.cost = cost;
    }

    public City getDestination() {
        return destination;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Path to " + destination.getName() + " (cost: " + cost + ")";
    }
}