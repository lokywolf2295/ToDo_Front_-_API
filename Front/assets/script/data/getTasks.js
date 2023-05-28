export const getTasks = async () => {
    const response = await fetch("http://127.0.0.1:8080/tasks");
    const tasks = await response.json();

    return tasks;
};

