
#include <sys/types.h>
#include <sys/sysctl.h>
#include "TargetConditionals.h"

#import <QuartzCore/CoreAnimation.h>
#import <Cordova/CDV.h>
#import "PGMultiview.h"


@implementation PGMultiview

@synthesize childViewController;



- (void)dismissView:(CDVInvokedUrlCommand*)command
{
    [self.viewController dismissViewControllerAnimated:YES completion:^{
        
    }];
    
}

- (void)loadView:(CDVInvokedUrlCommand*)command
{
    
    childViewController = [[CDVViewController alloc] init];
    childViewController.startPage = @"index.html"; // todo: this is a parameter
    
    self.viewController.modalPresentationStyle = UIModalPresentationNone;
    
    CATransition *transition = [CATransition new];
    transition.type = kCATransitionPush;
    transition.subtype = kCATransitionFromRight;
    
    // Add the transition
    [self.viewController.view.layer addAnimation:transition forKey:@"transition"];
    [self.viewController showViewController:childViewController sender:NULL];
    
}

@end