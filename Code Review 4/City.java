/* Продолжение задания №3.3 */
public class City {
    private String name;
    private Path[] paths;
    private int pathCount;
    private static final int maxPaths = 10;

    public City(String name) {
        this.name = name;
        this.paths = new Path[maxPaths];
        this.pathCount = 0;
    }

    public void addPath(City destination, int cost) {
        if (pathCount < maxPaths) {
            paths[pathCount] = new Path(destination, cost);
            pathCount++;
        } else {
            System.out.println("Достигнуто максимальное количество путей для города " + name);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(": ");

        for (int i = 0; i < pathCount; i++) {
            sb.append(paths[i].getDestination().getName())
                    .append(" (")
                    .append(paths[i].getCost())
                    .append("), ");
        }

        if (sb.length() > 2) {
            sb.setLength(sb.length() - 2);
        }

        return sb.toString();
    }

    public String getName() {
        return name;
    }
}