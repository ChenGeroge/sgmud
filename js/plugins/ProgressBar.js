(() => {
  /**
   * 进度条窗口
   * $gameMessage.setProgress(0, 10, "666");
   */
  class Window_Progress extends Window_Base {
    constructor() {
      super();
      this.initialize.apply(this, arguments);
    }
    initialize() {
      this._frames = 0;
      var width = this.windowWidth();
      var height = this.windowHeight();
      var x = (Graphics.boxWidth - width) / 2;
      const y = height;
      Window_Base.prototype.initialize.call(this, 9999, y, width, height);
      this.close();
      this.deactivate();
      //this.refresh();
    }
    open() {
      this._frames = 0;
      var width = this.windowWidth();
      var height = this.windowHeight();
      var x = (Graphics.boxWidth - width) / 2;
      const y = height;
      this.move(x, y, width, height);
      super.open();
      this.activate();
      this.refresh();
    }
    windowWidth() {
      return 400;
    }
    windowHeight() {
      return this.fittingHeight(1);
    }
    refresh() {
      var x = this.textPadding();
      var width = this.contents.width;
      this.contents.clear();
      var max = $gameMessage.progressMax;
      var val = $gameMessage.progressVal;
      const title = $gameMessage.progressTitle;
      this.drawGaugeBar(
        title,
        Math.min(val, max),
        max,
        0,
        0,
        width,
        true,
        true,
        this.tpGaugeColor1(),
        this.tpGaugeColor2()
      );
    }
    update() {
      Window_Base.prototype.update.call(this);
      if (!this.active) {
        return;
      }
      if (Input.isRepeated("cancel") || TouchInput.isCancelled()) {
        this.close();
        this.deactivate();
        $gameMessage.clear();
        return;
      }
      this._frames++;
      if (this._frames % 60 === 0) {
        $gameMessage.progressOnEachStep();
        if (
          !$gameMessage.progressMax ||
          $gameMessage.progressVal > $gameMessage.progressMax
        ) {
          this.close();
          this.deactivate();
          const onFinish = $gameMessage.progressOnFinish;
          $gameMessage.clear();
          setTimeout(onFinish, 500);
          return;
        }
        const stepValue =
          typeof $gameMessage.progressStep === "function"
            ? $gameMessage.progressStep()
            : $gameMessage.progressStep;
        $gameMessage.setProgress($gameMessage.progressVal + stepValue);
        this.refresh();
      }
    }
  }
  Game_Message.prototype.isProgress = function () {
    return this.progressTitle !== "";
  };
  Game_Message.prototype.setProgress = function (
    val,
    max = this.progressMax,
    title = this.progressTitle,
    step = this.progressStep,
    onEachStep = this.progressOnEachStep,
    onFinish = this.progressOnFinish
  ) {
    this.progressVal = val;
    this.progressMax = max;
    this.progressTitle = title;
    this.progressStep = step;
    this.progressOnEachStep = onEachStep;
    this.progressOnFinish = onFinish;
  };
  PluginManager.regBatchHooks({
    "Game_Message.prototype.clear": (oFunc) =>
      function () {
        oFunc();
        this.progressMax = 0;
        this.progressVal = 0;
        this.progressTitle = "";
        this.progressOnEachStep = () => {};
        this.progressOnFinish = () => {};
      },
    "Game_Message.prototype.isBusy": (oFunc) =>
      function () {
        return oFunc() || this.isProgress();
      },
    "Window_Message.prototype.startInput": (oFunc) =>
      function () {
        if ($gameMessage.isProgress()) {
          this._mapProgressWindow.open();
          return true;
        } else {
          return oFunc();
        }
      },
    "Window_Message.prototype.createSubWindows": (oFunc) =>
      function () {
        oFunc();
        this._mapProgressWindow = new Window_Progress(this);
      },
    "Window_Message.prototype.subWindows": (oFunc) =>
      function () {
        return [...oFunc(), this._mapProgressWindow];
      },
    "Window_Message.prototype.isAnySubWindowActive": (oFunc) =>
      function () {
        return oFunc() || this._mapProgressWindow.active;
      },
  });
})();
