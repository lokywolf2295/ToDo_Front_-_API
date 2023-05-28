import { createTask } from "./addTask.js";
import dateElement from "./dateElement.js";
import { uniqueDates, orderDates } from "../service/date.js";
import { getTasks } from "./../data/getTasks.js";

export const displayTasks = async () => {
  let tasks = await getTasks();

  const list = document.querySelector("[data-list]"); //linkeamos el contenedor de los mensajes
  const dates = uniqueDates(tasks);
  const orderedDates = orderDates(dates);

  orderedDates.forEach((date) => {
    const dateMoment = moment(date, "DD/MM/YYYY");
    list.appendChild(dateElement(date));

    tasks.forEach((task) => {
      const taskDate = moment(task.date, "YYYY/MM/DD").format("DD/MM/YYYY");
      const diff = dateMoment.diff(moment(taskDate, "DD/MM/YYYY"), "days");

      if (diff == 0) {
        list.appendChild(createTask(task));
      }
    });
  });
};
