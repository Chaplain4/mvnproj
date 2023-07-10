package abs;

public interface Drawable {
    void draw();
}


class Triangle implements Drawable {
    int a, b, c;

    @Override
    public void draw() {
        System.out.println("Δ");
    }
}

class Circle implements Drawable {
    int r;

    @Override
    public void draw() {
        System.out.println("○");
    }
}

class Square implements Drawable {
    int a;

    @Override
    public void draw() {
        System.out.println("□");
    }
}

class DrawTester {
    public static void main(String[] args) {
        new Triangle().draw();
        new Circle().draw();
        new Square().draw();
    }
}