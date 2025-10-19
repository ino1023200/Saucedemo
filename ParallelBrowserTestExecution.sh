#!/bin/bash

echo "╔════════════════════════════════════════════════════════════╗"
echo "║     MULTI-BROWSER PARALLEL TEST EXECUTION                  ║"
echo "╚════════════════════════════════════════════════════════════╝"
echo ""

# Chạy Maven với profile parallel-browsers
mvn clean test -P parallel-browsers

# Check exit code
if [ $? -eq 0 ]; then
    echo ""
    echo -e "Test execution completed!${NC}"
    echo ""
    echo "📊 Reports:"
    echo "   - Chrome HTML: target/cucumber-reports/chrome/cucumber.html"
    echo "   - Firefox HTML: target/cucumber-reports/firefox/cucumber.html"
    echo "   - Surefire: target/surefire-reports-parallel/"
    echo ""
else
    echo ""
    echo -e "Some tests may have failed. Check reports for details.${NC}"
    echo ""
fi
