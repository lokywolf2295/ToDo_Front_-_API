import checkComplete from "./checkComplete.js";
import createDelIcon from "./deleteIco.js";
import { displayTasks } from "./displayTasks.js";
import { sendTask } from "../data/sendTask.js";

export const addTask = (event) => {
  event.preventDefault(); //evita que se recargue la pagina borrando la información

  const list = document.querySelector("[data-list]"); //guardamos el ul que contendra los mensajes
  const input = document.querySelector("[data-form-input]"); //guardamos el input
  const calendar = document.querySelector("[data-form-date]"); //guardamos el input de la fecha

  const title = input.value; //guardamos la información del input
  const date = calendar.value; //guardamos la información de la fecha
  const dateFormat = moment(date).format("yyyy-MM-DD");
  const time = moment(date).format("HH:mm");

  if (input == "" || date == "") {
    //corroboramos que ambos inputs tengan información
    return;
  }

  input.value = ""; //vaciamos el input
  calendar.value = ""; //vaciamos el calendario

  const finished = false; //se utilizará para verificar si el check está activado o no

  const taskObj = {
    //crea una variable que almacena una clave y su valor
    title, //texto
    date:dateFormat, //fecha
    time, //hora
    finished, //para el check
  };

  list.innerHTML = ""; //por cada vez que se agreguen tareas nuevas se vacía la estructura
  
  sendTask(taskObj); //llama a la función que envía la tarea a la API
  displayTasks(); //llama a la función que agrupa las fechas
};

//Arrow function o funciones flechas / anonimas
export const createTask = ({ id, title, time,finished}) => {
  
  const task = document.createElement("li"); //creo un elemento li
  task.classList.add("card"); //agregamos una clase al task

  //backticks
  const taskContent = document.createElement("div"); //creo un elemento div

  const check = checkComplete(id,finished);

  const titleTask = document.createElement("span"); //creo un elemento span
  titleTask.classList.add("task"); //agregamos la clase task al titleTask
  titleTask.innerText = title; //agregamos al titleTask el valor del inpút
  taskContent.appendChild(check); //agregamos al div check
  taskContent.appendChild(titleTask); //agregamos al contenido el titleTask

  const dateElement = document.createElement("span"); //creo el elemento span para la fecha
  dateElement.innerHTML = time; //le agrego al span la hora obtenida
  task.appendChild(taskContent); //agrego al task el div con la info ingresada en el input
  task.appendChild(dateElement); //agrego al task la fecha
  task.appendChild(createDelIcon(id)); //agrego al contenido el icono del basurero
  return task;
};
