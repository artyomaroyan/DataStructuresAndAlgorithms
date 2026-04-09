/**
 * Author: artyom_aroyan
 * Date: 10.07.25
 * Time: 02:47:09
 */
private static final Random RANDOM = new Random();

void main() {
    generateRandomIntNumber();
    generateRandomDoubleNumber();
    randomDoubleNumbers();
}

private static void generateRandomIntNumber() {
    // Generate between 10 and 30 random numbers
    int count = RANDOM.nextInt(5) + 15;

    // Generate random integers (0-100)
    int[] numbers = RANDOM.ints(count, -100, 100).toArray();
    IO.println(String.format("Generated %d random integers: %s", count, Arrays.toString(numbers)));
}

private static void generateRandomDoubleNumber() {
    // Generate between 15 and 30 random numbers
    int count = RANDOM.nextInt(1) + 3;

    // Stores both Integers and Doubles
    List<Number> numbers = new ArrayList<>();

    for (int i = 0; i < count; i++) {
        if (RANDOM.nextBoolean()) { // 50% chance for int, 50% for double
            numbers.add(RANDOM.nextInt(101)); // Integer (0-100)
        } else {
            numbers.add(Math.round(RANDOM.nextDouble() * 100 * 100.0) / 100.0); // Double (0.0-100.0, 2 decimal places)
        }
    }
    IO.println(String.format("Generated %d mixed double or integer random numbers: %s", count, numbers));
}

private static void randomDoubleNumbers() {
    int count = 20;
    double min = 10_000;
    double max = 100_000;

    double[] numbers = new double[count];
    for (int i = 0; i < count; i++) {
        numbers[i] = min + (max - min) * RANDOM.nextDouble();
    }

    System.out.printf("Generated %d double random numbers: %s", count,
            Arrays.stream(numbers)
                    .mapToObj(v -> String.format("%.2f", v))
                    .collect(Collectors.joining(", ", "[", "]"))
    );
}