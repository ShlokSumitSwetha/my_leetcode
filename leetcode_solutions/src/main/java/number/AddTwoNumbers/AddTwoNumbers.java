package number.AddTwoNumbers;

public class AddTwoNumbers {
	public static void main(String[] args) {

		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);



		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		ListNode result =addTwoNumbers(l1, l2);
		System.out.println(result.val);
		System.out.println(result.next);
		System.out.println(result.next.val);
		System.out.println(result.next.next.val);

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		int carry = 0;

		while (l1 != null || l2 != null || carry != 0) {
			int digit1 = (l1 != null) ? l1.val : 0;
			int digit2 = (l2 != null) ? l2.val : 0;

			int sum = digit1 + digit2 + carry;
			int digit = sum % 10;
			carry = sum / 10;

			ListNode newNode= new ListNode(digit);
			tail.next = newNode;
			tail = tail.next;

			l1 = (l1 != null) ? l1.next : null;
			l2 = (l2 != null) ? l2.next : null;
		}

		ListNode result = dummy.next;
		dummy.next = null;
		return result;
	}
	}

