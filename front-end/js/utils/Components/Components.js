import Html from '../Html/html';
import Api from "../Api/Api"

export default () => new Components()

class Components {
    getAppContext() {
        return Html().select("#app");
    }

    getWrapperDiv() {
        return Html()
            .create("div")
            .addClass("wrapper");
    }

    renderAlbumForm() {
        const formContainer = Html().create('section').addClass('form-container');
        const form = Html().create('form').addAttribute('action', '#');
        const formTitle = Html().create('h2').addClass('form__title').text('Input an album');
        const labelSelect = Html().create('label').addClass('form__label').text('Artist Name:');
        const selectOption = Html().create('select');
        form.addChild(formTitle)
        form.addAttribute(labelSelect)

        //need to come back and add artist options when we have API built out

        form.addAttribute(selectOption)

        const inputList = ['Title', 'ImageUrl', 'Record Label']
        inputList.forEach((index) => {
            const label = Html().create('label').addClass('form__label').text(index);
            const input = Html().create('input').addClass('form__input').addAttribute('name', index).addAttribute('type', 'text').addAttribute('required', '');
            form.addChild(label.addChild(input))
        })
        const button = Html().create('button').addChild('form__button');
        form.addChild(button).text('Submit')
        //this will go last
        formContainer.addChild(form);

        return formContainer;
    }

    renderHeaderBlock(requestData) {
        const headerBlock = Html().create('header').addClass('main-header');
        const titleBlock = Html().create('h1').addClass('main-header__title').text("Album")
        headerBlock.addChild(titleBlock);
        return headerBlock
    }

    renderNavBlock() {
        const navBlock = Html().create('nav').addClass('nav');
        const navList = Html().create('ul').addClass('nav_list');

        const navListItemOne = Html().create('li')
            .addClass('nav__list-item')
            .addChild(
                Html().create('a')
                    .addAttribute('href', '#')
                    .text("Home")
                    .click((event) => {
                        event.preventDefault()
                        this.renderPageHome()

                    })
            )
        const navListItemTwo = Html().create('li')
            .addClass('nav__list-item')
            .addChild(
                Html().create('a')
                    .addAttribute('href', 'allArtistTemplate.html')
                    .text("Artist")
                    .click((event) => {
                        event.preventDefault()
                        this.renderPageArtist()

                    })
            )
        const navListItemThree = Html().create('li')
            .addClass('nav__list-item')
            .addChild(
                Html().create('a')
                    .addAttribute('href', 'allAlbumsTemplate.html')
                    .text("Albums")
                    .click((event) => {
                        event.preventDefault()
                        this.renderPageArtist()

                    })
            )
        const navListItemFour = Html().create('li')
            .addClass('nav__list-item')
            .addChild(
                Html().create('a')
                    .addAttribute('href', 'allSongsTemplate.html')
                    .text("Songs")
                    .click((event) => {
                        event.preventDefault()
                        this.renderPageSong()

                    })
            )
        navList.addChild(navListItemOne)
        navList.addChild(navListItemTwo)
        navList.addChild(navListItemThree)
        navList.addChild(navListItemFour)
        navBlock.addChild(navList)
        return navBlock;
    }

    renderFooter() {
        const footer = Html().create('footer').addClass('footer')
        const footerText = Html.create('small').addClass('footer__text').text('&copy; 2019');
        footer.addChild(footer);
        return footer;
    }

}