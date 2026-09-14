const Page = require('./page');

class DragPage extends Page {
  get screenTitle() { return $('~Drag-drop-screen'); }
  get firstDraggable() { return $('~drag-l1'); }
}

module.exports = new DragPage();
