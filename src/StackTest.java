/**
 * Eddie Ruano and Matt Piasecki
 * CPE 103 Fall 2015
 * Project 1
 *
 **/

import java.util.Scanner;

public class StackTest {

	public static void main(String[] args) {

		MyStack myStack = new MyStack();
		Scanner scan = new Scanner(System.in);
		boolean token = true;
		String selection;
		String throwaway;
		char selector;
		System.out.println("Choose one of the following operations:");
		System.out.println("- push/add (enter the letter a)");
		System.out.println("- pop/delete (enter the letter d)");
		System.out.println("- check empty (enter the letter e)");
		System.out.println("- peek/check (enter the letter p)");
		System.out.println("- quit (enter the letter q)");

		while (token) {

			System.out.println("Please input a command: ");
			selection = scan.nextLine();
			if (!selection.isEmpty()) {
				selector = selection.charAt(0);
			} else {
				System.out.println("Invalid choice");
				continue;
			}

			switch (selector) {
			case ('a'):
				System.out.print("Enter Integer: ");
				if (scan.hasNextInt()) {
					int inValue = scan.nextInt();
					myStack.push(inValue);
					System.out.println("'" + inValue + "' Added Successfully.");
					throwaway = scan.nextLine();
				} else {
					System.out.println("Entry was invalid.");
					throwaway = scan.nextLine();

				}

				break;
			case ('d'):
				try {
					Object outValue = myStack.pop();
					System.out.println("'" + outValue
							+ "' Removed Successfully.");
				} catch (RuntimeException e) {
					System.out
							.println("Invalid operation: the stack is empty.");
					break;
				}

				break;
			case ('e'):
				if (myStack.isEmpty()) {
					System.out.println("The stack is empty.");
				} else {
					System.out.println("The stack is NOT empty.");
				}

				break;
			case ('p'):
				try {
					Object peeker = myStack.peek();
					System.out.println("'" + peeker + "' is on the top.");
				} catch (RuntimeException e) {
					System.out
							.println("Invalid operation: the stack is empty.");
					break;
				}

				break;
			case ('q'):
				System.out.println("Quitting...");
				token = false;
				break;
			default:
				System.out.println("Invalid choice");
				break;

			}

		}

		while (!myStack.isEmpty()) {
			System.out.print(myStack.pop() + " ");
		}
		System.out.print("\n");

		scan.close();

	}

}
