import Html from './html.js'

describe("Html", () => {

    describe("create", () => {

        describe("should return new html object", () => {

            test("should be an object", () => {
                expect(typeof Html().create("h1")).toBe("object");

            })
            test("Throws error if given an improper HTML element", () => {
                expect(() => {
                    Html().create()
                }).toThrow('Invalid Html element')

            })
        })
    })
})