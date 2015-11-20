var hello = {
    world: function(str, callback) {
        cordova.exec(callback, function(err) {callback('Nothing to hello.');}, "Hello", "hello", [str]);
    }
}

module.exports = {hello, hey};
