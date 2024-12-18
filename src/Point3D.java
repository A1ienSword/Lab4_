class Point3D extends Point2D {
    private double z;

    // Конструктор
    public Point3D(double x, double y, double z) {
        super(x, y); // Вызов конструктора родительского класса
        this.z = z;
    }

    // Переопределение метода toString для трехмерной точки
    @Override
    public String toString() {
        return "{" + getX() + ";" + getY() + ";" + z + "}";
    }

    // Методы для получения координат (для доступа из toString)
    public double getX() {
        return super.getX(); // Получаем значение x из родительского класса
    }

    public double getY() {
        return super.getY(); // Получаем значение y из родительского класса
    }
}
