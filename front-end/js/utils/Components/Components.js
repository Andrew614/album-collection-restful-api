import Html from '../Html/html';
import Api from "../Api/Api";
import pictureUrl from "../../../images/music.jpg"

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
        const nav = this.renderNavBlock();
        headerBlock.addChild(titleBlock);
        headerBlock.addChild(nav);
        return headerBlock
    }

    renderNavBlock() {
        const navBlock = Html().create('nav').addClass('nav');
        const navList = Html().create('ul').addClass('nav__list');

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
                    .text("Artists")
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
        const footer = Html().create('footer').addClass('footer');
        const footerText = Html().create('small').addClass('footer__text').html('&copy; 2019');
        footer.addChild(footerText);
        return footer;
    }
    generateArticleCard() {
        const article = Html().create('article').addClass('card');
        const linkToSingleItem = Html().create('a').addClass('card__anchor');
        const img = Html().create('img').addClass('card__image').addAttribute('src', 'http://lorempixel.com/400/200').addAttribute('alt', 'alt picture');
        const section = Html().create('section').addClass('card__item');
        const sectionHeader = Html().create('h2').addClass('card__item--text').text('Artist');
        section.addChild(sectionHeader);
        linkToSingleItem.addChild(img);
        linkToSingleItem.addChild(section);
        article.addChild(linkToSingleItem);
        return article;
    }

    generateArtistList() {
        return this.generateContentBlockList('artists');
    }
    generateAlbumList() {
        return this.generateContentBlockList('albums');
    }

    generateSongsList() {
        return this.generateContentBlockList('songs');
    }

    renderPageArtists() {
        return this.renderWholePage('artists');
    }
    
    renderPageAlbums() {
        return this.renderWholePage('albums');
    }

    renderPageSongs() {
        return this.renderWholePage('songs');
    }
    
    renderWholePage(requestedContent) {
        const blockHeaderText = requestedContent.charAt(0).toUpperCase() + requestedContent.slice(1);
        const app = this.getAppContext();
        const wrapperDiv = this.getWrapperDiv();
        const mainHeader = this.renderHeaderBlock();
        const mainFooter = this.renderFooter();
        const container = Html().create('div').addClass('container');
        const block = Html().create('section').addClass('block');
        const blockHeader = Html().create('h1').addClass('block__title').text(blockHeaderText);
        const blockList = this.generateContentBlockList(requestedContent);
        blockHeader.addChild(blockList);
        block.addChild(blockHeader);
        container.addChild(block);
        wrapperDiv.addChild(mainHeader);
        wrapperDiv.addChild(container);
        wrapperDiv.addChild(mainFooter);
        app.addChild(wrapperDiv);
        return app;
    }
    generateContentBlockList(requestedContent) {
        const blockList = Html().create('div').addClass('block-list');
        const api = Api().getRequest(`http://localhost:8080/api/${requestedContent}`, (responseCollection) => {
            responseCollection.forEach((item) => {
                let name;
                name = item.name;
                if(item.title) {
                    name = item.title;
                }
                let imageUrl;
                imageUrl = item.imageUrl;
                if (!imageUrl) {
                    imageUrl = pictureUrl;
                }
                
                let itemLink;
                itemLink = '#'
                if (item.link) {
                    itemLink = item.link;
                }
                const article = Html().create('article').addClass('card');
                const linkToSingleItem = Html().create('a').addClass('card__anchor').addAttribute('href', itemLink);
                const img = Html().create('img').addClass('card__image').addAttribute('src', imageUrl).addAttribute('alt', 'alt picture');
                const section = Html().create('section').addClass('card__item');
                const sectionHeader = Html().create('h2').addClass('card__item--text').text(name);
                section.addChild(sectionHeader);
                linkToSingleItem.addChild(img);
                linkToSingleItem.addChild(section);
                article.addChild(linkToSingleItem);
                blockList.addChild(article);
            });
        });
        return blockList;
    }
}

