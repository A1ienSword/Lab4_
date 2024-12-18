class Point2D {
    private double x;
    private double y;

    // Конструктор
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Методы для получения координат
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Метод для получения текстового представления
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}
