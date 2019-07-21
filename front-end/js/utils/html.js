export default function () {
    return new Html();
}

class Html {
    create(elementType) {
        if (!elementType) {
            throw new Error('Must pass a HTML element')
        }

        this.element = document.createElement(elementType);

        if ((this.element instanceof HTMLUnknownElement)) {
            throw new Error('Invalid html element')
        }

        return this;
    }
    addClass(classToAdd){
        if (this.element.classList.contains(classToAdd)){
         throw new Error('duplicate class error')}

        this.element.classList.add(classToAdd)
        return this;
    }
    addChild(childToAdd){
        this.element.append(childToAdd.render())
        return this
    }
    render(){
        return this.element
    }

}