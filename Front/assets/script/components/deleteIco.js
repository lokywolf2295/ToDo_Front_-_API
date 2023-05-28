import { deleteTask } from "./../data/deleteTask.js";
import { displayTasks } from "./displayTasks.js";


const createDelIcon = (id) => {
    const i = document.createElement("i"); //creamos un elemento i
    i.classList.add("fas","fa-trash-alt", "trashIcon" ,"icon"); //agregamos las clase al elemento i
    i.addEventListener("click", () => dumpTask(id));
    return i; //devolvemos el valor de i
  };
  
  const dumpTask = (id) =>{
    const list = document.querySelector("[data-list]"); //seleccionamos la lista
    deleteTask(id);
    list.innerHTML = "";
    displayTasks(); //llamado, para mostrar las nuevas tareas modificadas
  }

  export default createDelIcon;