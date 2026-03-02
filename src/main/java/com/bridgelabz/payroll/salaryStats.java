package com.bridgelabz.payroll;

public class salaryStats {

        private double sum;
        private double average;
        private double min;
        private double max;
        private int count;

        public salaryStats(double sum, double average,
                           double min, double max, int count) {
            this.sum = sum;
            this.average = average;
            this.min = min;
            this.max = max;
            this.count = count;
        }

        public double getSum() { return sum; }
        public double getAverage() { return average; }
        public double getMin() { return min; }
        public double getMax() { return max; }
        public int getCount() { return count; }
}

