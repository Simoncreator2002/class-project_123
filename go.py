# Define a Stack class
class Stack:
    # The __init__ method is created in every class.
    # It holds the values for the instances (different objects) that are created.
    # It creates the stack (an empty list) that will be referenced.
    # Without the __init__ method, it becomes difficult for the different instances
    # to be created with their own fixed list.
    # The 'self' parameter in the __init__ method is like a family name assigned to all the kids.
    def __init__(self):
        # Initialize an empty list to store stack elements
        self.stack = []
    
    # The push method adds a friend's name to the top of the stack.
    # 'self' represents the current object and 'friend' is the name passed in.
    def push(self, friend):
        # Add a friend's name to the top of the stack using the append method
        self.stack.append(friend)
        print(f"{friend} has been added to the stack.")
        # The f-string (f"{friend}") formats the string to include the friend's name dynamically.
    
    # The pop method now takes a friend's name as an argument and removes that specific friend.
    # This is a non-standard behavior for a stack, but it meets your requirement.
    def pop(self, friend):
        # First, check if the stack is empty.
        if self.is_empty():
            print("The stack is empty, no friend to remove.")
            return None
        # Check if the friend is in the stack.
        if friend in self.stack:
            # Remove the friend from the stack.
            # list.remove() removes the first occurrence of the specified element.
            self.stack.remove(friend)
            print(f"{friend} has been removed from the stack.")
            return friend  # Return the removed friend to verify the correct element was removed.
        else:
            print(f"{friend} is not in the stack.")
            return None
    
    # The is_empty method checks if the stack is empty.
    # It returns True if the length of the stack is 0, meaning it's empty.
    def is_empty(self):
        return len(self.stack) == 0
    
    # The display method prints the current values in the stack.
    def display(self):
        print("Current stack:", self.stack)

# End of class

# Create an instance for our Stack class. The instance is called friend_stack.
friend_stack = Stack()

# Push friends onto the stack.
friend_stack.push("Emma")
friend_stack.push("Simon")
friend_stack.push("Junior")

# Display the stack.
friend_stack.display()

# removing a friend
friend_stack.pop("Emma")

# Display the stack again to show the updated list.
friend_stack.display()

 