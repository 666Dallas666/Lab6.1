package com.company;
public class Main {
    public static void main(String[] args){
        MovableRectangle Test = new MovableRectangle(4,2,"green",true,0,0,0,2,4,0,4,2,4,3);
        Test.moveDown();
        Test.moveRight();
        System.out.println ("Movable Rectangle: ");
        System.out.println (Test.toString());
        System.out.println ("\n");
        MovablePoints Test1 = new MovablePoints(0,0,2,2, 4,2);
        Test1.moveLeft();
        Test1.moveUp();
        System.out.println ("Movable Points: ");
        System.out.println(Test1.toString());
    }
    public interface Movable {
        public void moveUp();
        public void moveDown();
        public void moveLeft();
        public void moveRight();
    }
    public static class MovablePoint implements Movable {
        int x;
        int y;
        int xSpeed;
        int ySpeed;
        public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
            this.x = x;
            this.y = y;
            this.xSpeed = xSpeed;
            this.ySpeed = ySpeed;
        }
        @Override
        public void moveUp() {
            this.y += this.ySpeed;
        }
        @Override
        public void moveDown() {
            this.y -= this.ySpeed;
        }
        @Override
        public void moveLeft() {
            this.x -= this.xSpeed;
        }
        @Override
        public void moveRight() {
            this.x += this.xSpeed;
        }
        @Override
        public String toString() {
            return "MovablePoint{" +
                    "x=" + x +
                    ", y=" + y +
                    ", xSpeed=" + xSpeed +
                    ", ySpeed=" + ySpeed +
                    '}';
        }
    }
    public static class MovablePoints implements Movable {
        private MovablePoint topLeft;
        private MovablePoint bottomRight;
        public MovablePoints(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
            this.topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
            this.bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
        }
        @Override
        public String toString() {
            return "MovablePoints{" +
                    "topLeft=" + topLeft +
                    ", bottomRight=" + bottomRight +
                    '}';
        }
        @Override
        public void moveUp() {
            this.topLeft.moveUp();
            this.bottomRight.moveUp();
        }

        @Override
        public void moveDown() {
            this.topLeft.moveDown();
            this.bottomRight.moveDown();
        }

        @Override
        public void moveLeft() {
            this.topLeft.moveLeft();
            this.bottomRight.moveLeft();
        }

        @Override
        public void moveRight() {
            this.topLeft.moveRight();
            this.bottomRight.moveRight();
        }
    }
    abstract static class Shape{
        private String colour;
        private boolean filled;
        public Shape(String colour, boolean filled){
            this.colour = colour;
            this.filled = filled;
        }
        public String getShapeColour(){
            return colour;
        }
        public void setShapeColour(String colour){
            this.colour = colour;
        }
        public boolean getFilled(){
            return filled;
        }
        public void setFilled(boolean filled){
            this.filled = filled;
        }
        abstract public double getArea();
    }
    class Circle extends Shape{
        private double radius;
        private double diameter;
        public Circle(String colour, boolean filled, double radius, double diameter){
            super(colour, filled);
            this.radius = radius;
            this.diameter = diameter;
        }
        public double getRadius(){
            return radius;
        }
        public void setRadius(double radius){
            this.radius = radius;
        }
        public double getDiameter(){
            return diameter;
        }
        public void setDiameter(double diameter){
            this.diameter = diameter;
        }
        @Override
        public double getArea() {
            return (Math.PI * Math.pow(radius,2));
        }
    }
    static class Rectangle extends Shape{
        private int length;
        private int width;
        public Rectangle(int length, int width, String colour, boolean filled){
            super(colour, filled);
            this.length = length;
            this.width = width;
        }
        public void setLength(int length){
            this.length = length;
        }
        public int getLength(){
            return length;
        }
        public void setWidth(int width){
            this.width = width;
        }
        public int getWidth(){
            return width;
        }
        @Override
        public double getArea() {
            return (length*width);
        }
    }
    class Oval extends Circle{
        private double diameter1;
        private double diameter2;
        public Oval(double diameter1, double diameter2, String colour, boolean filled, double radius, double diameter){
            super(colour, filled, radius, diameter);
            this.diameter1 = diameter1;
            this.diameter2 = diameter2;
        }
        public void setDiameter1(double diameter1){
            this.diameter1 = diameter1;
        }
        public double getDiameter1(){
            return diameter1;
        }
        public void setDiameter2(double diameter2){
            this.diameter2 = diameter2;
        }
        public double getDiameter2(){
            return diameter2;
        }
        @Override
        public double getArea() {
            return Math.PI * diameter1 * diameter2;
        }
    }
    class Square extends Rectangle{
        private int side;
        public Square(int length, int width, String colour, boolean filled, int side){
            super(length, width, colour, filled);
            this.side = side;
        }
        public void setSide(int side){
            this.side = side;
        }
        public double getSide(){
            return side;
        }
        @Override
        public double getArea() {
            return side*side;
        }
    }
    public static class MovableRectangle extends Rectangle{
        private MovablePoint topLeft;
        private MovablePoint bottomRight;
        private MovablePoint topRight;
        private MovablePoint bottomLeft;
        public MovableRectangle(int length, int width, String colour, boolean filled, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int xSpeed, int ySpeed){
            super(length, width, colour, filled);
            this.topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
            this.bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
            this.topRight = new MovablePoint(x3, y3, xSpeed, ySpeed);
            this.bottomLeft = new MovablePoint(x4, y4, xSpeed, ySpeed);
        }
        @Override
        public String toString() {
            return "MovablePoints{" +
                    "topLeft=" + topLeft +
                    ", bottomRight=" + bottomRight +
                    ", topRight=" + topRight + ", bottomLeft=" + bottomLeft + '}';
        }
        public void moveDown() {
            this.topLeft.moveDown();
            this.bottomRight.moveDown();
            this.topRight.moveDown();
            this.bottomLeft.moveDown();
        }
        public void moveLeft() {
            this.topLeft.moveLeft();
            this.bottomRight.moveLeft();
            this.topRight.moveLeft();
            this.bottomLeft.moveLeft();
        }
        public void moveRight() {
            this.topLeft.moveRight();
            this.bottomRight.moveRight();
            this.topRight.moveRight();
            this.bottomLeft.moveRight();
        }
        public void moveUp() {
            this.topLeft.moveUp();
            this.bottomRight.moveUp();
            this.topRight.moveUp();
            this.bottomLeft.moveUp();
        }
    }
}