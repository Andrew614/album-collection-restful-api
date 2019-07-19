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

}