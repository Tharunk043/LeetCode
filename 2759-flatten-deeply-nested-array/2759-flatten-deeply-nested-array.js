/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, n) {
    if (n === 0) return arr; // no flattening if depth is 0
    
    let result = [];
    
    for (let item of arr) {
        if (Array.isArray(item) && n > 0) {
            // recursively flatten deeper arrays
            result.push(...flat(item, n - 1));
        } else {
            result.push(item);
        }
    }
    
    return result;
};
