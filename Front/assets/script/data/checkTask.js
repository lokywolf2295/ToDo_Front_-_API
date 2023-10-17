import { path } from "../data/path.js";

export const checkTask = async (id,finished) => {
  const url = path + "mark_as_finished/" + id+"/"+finished;
  fetch(url, {
    method: "PATCH",
  })
    .then((res) => {
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
      Swal.fire({
        position: "center",
        icon: "error",
        title: "Error en la solicitud:" + error, // Maneja el error de acuerdo a tus necesidades
        showConfirmButton: false,
        timer: 1500,
      });
    });
};
