fun main() {

    val todoList = mutableListOf<String>()

    // Starts the main application loop. It runs continuously until explicitly broken (when the user chooses '4. Exit').
    while (true) {
        // Display the main menu options to the user.
        println("\nTo-Do List")
        println("1. View tasks")
        println("2. Add task")
        println("3. Remove task")
        println("4. Exit")
        print("Choose an option (1-4): ")

        // Reads the user's input from the console and trims any whitespace.
        when (readln().trim()) {
            "1" -> viewTasks(todoList)
            "2" -> addTask(todoList)
            "3" -> removeTask(todoList)
            "4" -> {
                println("👋 Goodbye!")
                break // Breaks out of the 'while (true)' loop, terminating the program.
            }
            // Default case for any invalid input (not 1, 2, 3, or 4).
            else -> println("Invalid option. Try again.")
        }
    }
}

/**
 * Displays the current list of tasks to the user.
 *
 * @param tasks The immutable list of String tasks to be displayed.
 */
fun viewTasks(tasks: List<String>) {
    // Check if the list is empty and print a corresponding message.
    if (tasks.isEmpty()) {
        println("No tasks yet.")
    } else {
        println("Your Tasks:")
        // 'forEachIndexed' iterates through the list, providing both the index and the task string.
        tasks.forEachIndexed { index, task ->
            // Print the task
            println("${index + 1}. $task")
        }
    }
}

/**
 * Prompts the user for a new task and adds it to the list.
 *
 * @param tasks The mutable list of String tasks to which the new task will be added.
 */
fun addTask(tasks: MutableList<String>) {
    print("Enter a new task: ")
    // Read the new task input and trim whitespace.
    val task = readln().trim()

    // Validate that the task is not an empty string.
    if (task.isNotEmpty()) {
        tasks.add(task) // Add the task to the mutable list.
        println("Task added.")
    } else {
        println("Task cannot be empty.")
    }
}

/**
 * Prompts the user for a task number and removes the corresponding task.
 *
 * @param tasks The mutable list of String tasks from which the task will be removed.
 */
fun removeTask(tasks: MutableList<String>) {
    // Early exit if the list is empty.
    if (tasks.isEmpty()) {
        println("No tasks to remove.")
        return
    }

    // Display the current list so the user knows the task numbers.
    viewTasks(tasks)
    print("Enter task number to remove: ")

    val input = readln()
    // 'toIntOrNull()' attempts to convert the string input to an Int, returning null if unsuccessful.
    val index = input.toIntOrNull()

    // Check if conversion was successful (.i.e index is not null) AND if the number is within the valid range (1 to list size).
    if (index != null && index in 1..tasks.size) {
        // Remove the task.
        val removed = tasks.removeAt(index - 1)
        println("Removed: \"$removed\"")
    } else {
        println("Invalid task number.")
    }
}