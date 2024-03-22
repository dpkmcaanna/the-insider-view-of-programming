package programming.injava.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosetPoints {

	public static void main(String[] args) {

		int[][] points = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
		List<Point> kclosetPoints = findKClosetPoint(points, 2);
		
		for(Point p : kclosetPoints) {
			System.out.println("Points: " + p.x + ", " + p.y + ", distance from origin: " + p.distance);
		}
	}
	
	public static List<Point> findKClosetPoint(int[][] points, int k) {
		
		PriorityQueue<Point> pq = new PriorityQueue<Point>(k, Comparator.comparingDouble(Point::getDistance));
		
		for(int[] p : points) {
			Point point = new Point(p[0], p[1]);
			pq.offer(point);
		}
		
		List<Point> result = new ArrayList<Point>();
		
		while(k-- > 0) {
			Point p = pq.poll();
			result.add(p);
		}
		
		return result;
	}

}


class Point {
	int x;
	int y;
	double distance;
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.distance = Math.sqrt(x*x + y*y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
}