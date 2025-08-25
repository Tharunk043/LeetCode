/**
 * @param {*} obj
 * @param {*} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
    if (obj === null || obj === undefined) return false;
    if (typeof classFunction !== "function") return false;

    let proto = Object.getPrototypeOf(obj);
    while (proto) {
        if (proto === classFunction.prototype) {
            return true;
        }
        proto = Object.getPrototypeOf(proto);
    }
    return false;
};

/**
 * Examples
 */
console.log(checkIfInstanceOf(new Date(), Date));  // true
console.log(checkIfInstanceOf([], Array));         // true
console.log(checkIfInstanceOf(123, Number));       // false (primitive not object)
console.log(checkIfInstanceOf(new Number(123), Number)); // true (boxed number)
