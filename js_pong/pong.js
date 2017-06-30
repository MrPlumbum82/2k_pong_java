class Vec {
  constructor
}
class Rect {}
const canvas = document.getElementById("pong");
const context = canvas.getContext("2d");
context.fillStyle = "#000000";
context.fillRect(0, 0, canvas.width, canvas.height);
context.fillStyle = "#ffffff";
context.fillRect(0, 0, 20, 20);