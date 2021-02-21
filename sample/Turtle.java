package sample;
import javafx.scene.shape.Line;

import java.awt.geom.*;
import java.util.*;
import java.lang.Math;
import java.io.*;

public class Turtle {
    private Stack<State> history;
    private Queue<Line2d> lines;

    public Turtle() {
        this.history = new Stack<State>();
        this.lines = new LinkedList<Line2d>();
        State initial = new State(new Point2D.Double(0.0,0.0), 90.0);
        push(initial);
    }


    public State getCurrentState() {
        return this.history.peek();
    }


    public Queue<Line2d> getLines() {
        return this.lines;
    }

    /**
     * Add a line
     * @param origin
     * @param end
     */
    public void drawLine(Point2D origin, Point2D end) {
        double x1 = origin.getX();
        double y1 = origin.getY();
        double x2 = end.getX();
        double y2 = end.getY();
        Line2d line = new Line2d(x1, y1, x2, y2);
        this.lines.add(line);
    }

    public void move(double d) {

        //get current position
        State current = getCurrentState();
        Point2D currentPos = current.getPos();
        double x1 = currentPos.getX();
        double y1 = currentPos.getY();
        double theta = current.getTheta();

        //new position calculations
        double x2 =  x1 + d * Math.cos(theta);
        double y2 = y1 + d * Math.sin(theta);
        Point2D newPos = new Point2D.Double(x2, y2);

        //update the current state
        State newState = new State(newPos, theta);
        push(newState);
    }

    public void draw(double d) {

        //move to new position
        State current = getCurrentState();
        move(d);
        State newState = getCurrentState();

        //find the origin and end points
        Point2D origin = current.getPos();
        Point2D end = newState.getPos();

        //draw the line
        drawLine(origin, end);
    }

    public void turnL(double angle) {

        //get the current direction
        State current = getCurrentState();
        Point2D currentPos = current.getPos();
        double currentTheta = current.getTheta();

        //new direction calculations
        double newTheta = currentTheta + angle;

        //update the current state
        State  newState = new State(currentPos, newTheta);
        push(newState);
    }

    public void turnR(double angle) {

        //get the current direction
        State current = getCurrentState();
        Point2D currentPos = current.getPos();
        double currentTheta = current.getTheta();

        //new direction calculations
        double newTheta = currentTheta - angle;

        //update the current state
        State  newState = new State(currentPos, newTheta);
        push(newState);
    }

    public void push(State state) {
        this.history.push(state);
    }

    public void pop() {
        this.history.pop();
    }

    public void stay() {
        //stay :/
    }

}

class State {
    private Point2D pos;
    private double theta;

    public State(Point2D pos, double theta) {
        this.pos = pos;
        this.theta = theta;
    }

    public Point2D getPos() {
        return this.pos;
    }

    public double getTheta() {
        return this.theta;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }
}
