#!/bin/bash

echo "╔════════════════════════════════════════════════════════════╗"
echo "║     MULTI-BROWSER PARALLEL TEST EXECUTION                  ║"
echo "╚════════════════════════════════════════════════════════════╝"
echo ""

# Colors
GREEN='\033[0;32m'
BLUE='\033[0;34m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

echo -e "${BLUE}Starting parallel test execution...${NC}"
echo -e "${YELLOW}Chrome & Firefox will run simultaneously${NC}"
echo ""

# Chạy Maven với profile parallel-browsers
mvn clean test -P parallel-browsers

# Check exit code
if [ $? -eq 0 ]; then
    echo ""
    echo -e "${GREEN}Test execution completed!${NC}"
    echo ""
    echo "📊 Reports:"
    echo "   - Chrome HTML: target/cucumber-reports/chrome/cucumber.html"
    echo "   - Firefox HTML: target/cucumber-reports/firefox/cucumber.html"
    echo "   - Surefire: target/surefire-reports-parallel/"
    echo ""
else
    echo ""
    echo -e "${YELLOW}Some tests may have failed. Check reports for details.${NC}"
    echo ""
fi
