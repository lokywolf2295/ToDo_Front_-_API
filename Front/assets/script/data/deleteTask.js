export const deleteTask = async (id) => {

    const url = "http://127.0.0.1:8080/tasks/delete/" +id
    console.log(url);
    fetch(url, {
        method: 'DELETE'
      })
      .then((res) => {
        if (res.ok) {
          console.log("Tarea eliminada");
        } else{
          console.log("No se eliminó correctamente");
        }
      })
      .catch(error => {
        console.error('Error en la solicitud:', error);
        // Maneja el error de acuerdo a tus necesidades
      });
}