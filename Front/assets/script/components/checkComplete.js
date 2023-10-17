import { checkTask } from "../data/checkTask.js";

const checkComplete = (id,finished) => {
    //console.log(id);
    //console.log(finished);
    const i = document.createElement("i"); //creamos un elemento i
    i.classList.add("far", "fa-check-square", "icon");
    if(finished){
      i.classList.toggle("fas");
      i.classList.toggle("completeIcon");
      i.classList.toggle("far"); //agregamos las clase al elemento i
    }
    i.addEventListener("click", (event) => completeTask(event, id,finished));
    return i; //devolvemos el valor de i
  };
  
  const completeTask = (event, id,finished) =>{
    const element = event.target;
    element.classList.toggle("fas");
    element.classList.toggle("completeIcon");
    element.classList.toggle("far"); //agregamos las clase al elemento i
    checkTask(id,finished);
  }

  export default checkComplete;