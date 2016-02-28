
#include <sys/types.h>
#include <sys/sysctl.h>
#include "TargetConditionals.h"

#import <QuartzCore/CoreAnimation.h>
#import <Cordova/CDV.h>
#import "PGMultiview.h"

@implementation PGMultiviewController

- (void)motionEnded:(UIEventSubtype)motion withEvent:(UIEvent *)event {
    if (UIEventSubtypeMotionShake) {
        [self.navigationController popViewControllerAnimated:YES];
    }
}

@end


@implementation PGMultiview

@synthesize childViewController;

- (BOOL) shouldOverrideLoadWithRequest:(NSURLRequest*)request navigationType:(UIWebViewNavigationType)navigationType
{
    return YES;
}


- (void)dismissView:(CDVInvokedUrlCommand*)command
{
    [self.viewController.navigationController popViewControllerAnimated:YES];
    self.viewController.navigationController.navigationBarHidden = YES;
    childViewController = NULL;
}

- (void)loadView:(CDVInvokedUrlCommand*)command
{
    childViewController = [[PGMultiviewController alloc] init];
    childViewController.startPage = [command argumentAtIndex:0];
    
    if(self.viewController.navigationController == NULL)
    {
        UINavigationController* nav = [[UINavigationController alloc] init];
        nav.navigationBarHidden = NO;
        self.webView.window.rootViewController = nav;
        [nav pushViewController:self.viewController animated:NO];
        nav.hidesBarsOnSwipe  = YES;
        nav.hidesBarsOnTap = YES;

    }

    [self.viewController.navigationController pushViewController:childViewController animated:YES];
}

@end