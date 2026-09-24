package enume.usecase4;

public enum Operation {
    PLUS {
        public double apply(double x, double y) { return x + y; }
    },
    MINUS {
        public double apply(double x, double y) { return x - y; }
    },
    MULTIPLY {
        public double apply(double x, double y) { return x * y; }
    },
    DIVIDE {
        public double apply(double x, double y) { return x / y; }
    };

    // Every constant MUST implement this method
    public abstract double apply(double x, double y);
}

class Main{
    public static void main(String[] args) {
        double result = Operation.PLUS.apply(5, 3); // Returns 8.0
    }
}
