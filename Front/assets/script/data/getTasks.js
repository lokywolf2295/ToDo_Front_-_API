export const getTasks = async () => {
    const response = await fetch("http://127.0.0.1:8080/api/v1/tasks/all");
    const tasks = await response.json();

    return tasks;
};

