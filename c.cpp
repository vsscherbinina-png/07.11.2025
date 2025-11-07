#include <iostream>
#include <vector>
#include <tuple>

std::vector<std::vector<int>> combinations_correct(const std::vector<int>& l, int k) {
    if (k == 0) {
        return {{}};
    }
    if (k > static_cast<int>(l.size())) {
        return {};
    }

    std::vector<std::vector<int>> comb;
    for (size_t i = 0; i < l.size(); ++i) {
        std::vector<int> rem_items(l.begin() + i + 1, l.end());
        auto rem_comb = combinations_correct(rem_items, k - 1);
        for (auto& c : rem_comb) {
            std::vector<int> new_comb = {l[i]};
            new_comb.insert(new_comb.end(), c.begin(), c.end());
            comb.push_back(new_comb);
        }
    }
    return comb;
}

int main() {
    int n = 4;
    int k = 2;
    std::vector<int> input;
    for (int i = 1; i <= n; ++i) {
        input.push_back(i);
    }
    auto result = combinations_correct(input, k);
    for (const auto& comb : result) {
        std::cout << "(";
        for (size_t i = 0; i < comb.size(); ++i) {
            std::cout << comb[i];
            if (i + 1 < comb.size()) std::cout << ", ";
        }
        std::cout << ")";
        if (&comb != &result.back()) std::cout << ", ";
    }
    std::cout << std::endl;
    return 0;
}
