
#import <UIKit/UIKit.h>
#import <Cordova/CDVPlugin.h>

@interface PGMultiViewController : CDVViewController
{}
@end



@interface PGMultiView : CDVPlugin
{}

@property (nonatomic, strong) PGMultiViewController* childViewController;



- (void)loadView:(CDVInvokedUrlCommand*)command;
- (void)dismissView:(CDVInvokedUrlCommand*)command;



@end