export default function () {
    return new Html();
}

class Html {
    create(elementType) {
        this.element = document.createElement(elementType);
        return this;
    }
}