/* Продолжение задания №2.1 */
public class Line {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public void setStart(Point newStart) {
        this.start = newStart;
    }

    public void setEnd(Point newEnd) {
        this.end = newEnd;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Линия от " + start.toString() + " до " + end.toString();
    }
}