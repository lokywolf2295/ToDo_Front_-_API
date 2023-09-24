export const deleteTask = async (id) => {
  const url = "http://127.0.0.1:8080/api/v1/tasks/delete/" + id;
  //console.log(url);
  fetch(url, {
    method: "DELETE",
  })
    .then((res) => {
      if (res.ok) {
        Swal.fire({
          //luego de copiar aparece un pop up de exito
          position: "center",
          icon: "success",
          title: "Tarea eliminada",
          showConfirmButton: false,
          timer: 2500,
        });
        setTimeout(() => {
          window.location.href = "index.html";
        }, 2500);
      } else {
        Swal.fire({
          position: "center",
          icon: "error",
          title: "No se eliminó correctamente",
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
