import Components from './utils/Components/Components'

export default function main() {
    const app = document.querySelector('#app');
    app.append(Components().renderHeaderBlock());
}
