import { path } from "./path.js";

export const sendTask = (taskObj) => {
  console.log(taskObj) 
  const url = `${path}create`;
  //const url = `${path}create/{"title":"${taskObj.title}","date":"${taskObj.dateFormat}","time":"${taskObj.time}"}`;
  console.log(url);
  fetch(url, {
    method: "POST",
    body: JSON.stringify(taskObj).toString(), // data can be `string` or {object}!
    headers: {
      "Content-Type": "application/json",
    },
  }).then((res) => {
    if (res.ok) {
      window.location.href = "index.html";
    } else {
      Swal.fire({
        position: "center",
        icon: "error",
        title: "No se actualizó correctamente",
        showConfirmButton: false,
        timer: 1500,
      });
    }
  })
  .catch((error) => {
    console.log("Error en la solicitud:" + error, )// Maneja el error de acuerdo a tus necesidades
    });
};
