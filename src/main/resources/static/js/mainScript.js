
function onClick(event) {
  const menuElem = event.currentTarget;
  menuElem.style.borderBottomColor = "black";
  menuElem.style.borderStyle = "solid";
  menuElem.style.borderBottomWidth = "10px";
  console.log("ebebbebebe");
}

document.querySelector("#cards").addEventListener('click', onClick);