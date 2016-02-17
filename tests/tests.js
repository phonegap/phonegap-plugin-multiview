
exports.defineAutoTests = function() {

    describe('PGMultiview', function () {
        it("should exist", function() {
            expect(PGMultiview).toBeDefined();
        });

        it("should have a loadView function", function() {
            expect(PGMultiview.loadView).toBeDefined();
            expect(PGMultiview.loadView).toEqual(jasmine.any(Function));
        });

        it("should have a dismissView function", function() {
            expect(PGMultiview.dismissView).toBeDefined();
            expect(PGMultiview.dismissView).toEqual(jasmine.any(Function));
        });
    });
}