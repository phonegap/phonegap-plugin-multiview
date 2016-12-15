
#import <UIKit/UIKit.h>
#import <Cordova/CDVPlugin.h>

// ==========

@protocol PGMultiViewDelegate <NSObject>

 - (void)dismissWithResult:(NSString*)result;

@end

// ==========

@interface PGMultiViewController : CDVViewController
{}

@property (nonatomic, strong) id <PGMultiViewDelegate> pgmDelegate;
@property (nonatomic, strong) NSString* messageFromParent;
@end


// ==========

@interface PGMultiView : CDVPlugin<PGMultiViewDelegate,UINavigationControllerDelegate>
{}


@property (nonatomic, strong) PGMultiViewController* childViewController;
@property (nonatomic, strong) NSString* callbackId;


- (void)loadView:(CDVInvokedUrlCommand*)command;
- (void)dismissView:(CDVInvokedUrlCommand*)command;
- (void)getMessage:(CDVInvokedUrlCommand*)command;

- (void)dismissWithResult:(NSString*)result;


@end
